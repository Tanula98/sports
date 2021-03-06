import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class ZookeeperApp {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException
    {
        if (args.length < 1) {
            System.err.println(ZookeeperAppConstants.NOT_ENOUGH_ARGS_ERROR_MESSAGE);
            return;
        }

        int serverPort = Integer.parseInt(args[0]);

        ActorSystem system = ActorSystem.create(ZookeeperAppConstants.ACTOR_SYSTEM_NAME);
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        HttpRouter instance = new HttpRouter(system);


        ZookeeperExecutor zookeeperExec = new ZookeeperExecutor(instance.getCacheActor(), serverPort);


        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                instance.createRoute(http).flow(system, materializer);

        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost(ZookeeperAppConstants.HOST, serverPort),
                materializer
        );


        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());


    }
}
