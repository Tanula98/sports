//б. создаем с помощью api route в акка http сервер который принимает два
//параметра, и если счетчик не равен 0, то сначала получает новый урл сервера
//(от актора хранилища конфигурации) и делает запрос к нему с аналогичными
//query параметрами (url, counter) но счетчиком на 1 меньше. Либо осуществляет
//запрос по url из параметра

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;

public class HttpRouter extends AllDirectives {

    private final ActorRef cacheActor;

    HttpRouter(ActorSystem system) {
        cacheActor = system.actorOf(CacheActor.props(), ZookeeperAppConstants.CACHE_ACTOR_NAME);
    }


    public ActorRef getCacheActor() {
        return cacheActor;
    }

    Route createRoute(Http http) {

    }

}
