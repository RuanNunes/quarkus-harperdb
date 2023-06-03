package ruan.nunes.harperdb;

import ruan.nunes.harperdb.auth.Authorization;
import ruan.nunes.harperdb.config.HarperDBConfig;

public class HarperDB {

    private final HarperDBConfig config;
    private final Authorization auth;

    private HarperDB(HarperDBConfig config, Authorization auth) {
        this.config = config;
        this.auth = auth;
    }

    public static HarperDB create(HarperDBConfig config, Authorization auth) {
        return new HarperDB(config, auth);
    }

}
