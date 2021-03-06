public class ZookeeperAppConstants {


    static final String SERVERS_NODE = "/servers";
    static final String SERVERS_NODES_PATH = SERVERS_NODE + "/";
    static final String SERVER_NODE = SERVERS_NODES_PATH + "s";
    // Actors constants
    static final String ACTOR_SYSTEM_NAME = "routes";
    static final String CACHE_ACTOR_NAME = "cacheActor";


    static final String WATCHER_MESSAGE = "Servers list has been updated";
    static final String REDIRECT_MESSAGE = "Redirect to ";
    static final String FETCH_MESSAGE = "fetch ";
    static final String NOT_ENOUGH_ARGS_ERROR_MESSAGE = "Not enough arguments. Run program with argument [serverPort]";



    // HTTP query parameters
    static final String URL_PARAMETER_NAME = "url";
    static final String COUNT_PARAMETER_NAME = "count";

    // Zookeeper constants
    static final String ZOOKEEPER_PORT = "2181";
    static final String ZOOKEEPER_SERVER = "127.0.0.1";
    static final int ZOOKEEPER_SESSION_TIMEOUT = 5000;

    // Server constants
    static final String HOST = "localhost";


}
