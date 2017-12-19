package lesson5_executors.client_server.util;

import lesson5_executors.client_server.servers.concurrent.ConcurrentServer;

public abstract class ConcurrencyCommand extends Command implements CacheExecute {

    protected final ConcurrentServer server;
    private boolean isCacheable;

    public ConcurrencyCommand(String[] command, final ConcurrentServer concurrentServer) {
        super(command);
        this.server = concurrentServer;
        setCacheable(true);
    }

    public boolean isCacheable() {
        return this.isCacheable;
    }

    public void setCacheable(boolean cacheable) {
        isCacheable = cacheable;
    }

}
