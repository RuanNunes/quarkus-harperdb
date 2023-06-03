package ruan.nunes.harperdb.config;


import ruan.nunes.harperdb.config.parser.ConfigParser;
import ruan.nunes.harperdb.config.source.ClasspathConfigSource;
import ruan.nunes.harperdb.config.source.ConfigSource;

public final class Configuration {

    private ConfigSource source;
    private ConfigParser parser;

    private Configuration() {
    }

    static Configuration create() {
        return new Configuration();
    }

    public Configuration withSource(ConfigSource source) {
        this.source = source;
        return this;
    }

    public ConfigSource getSource() {
        return source;
    }

    public Configuration withParser(ConfigParser parser) {
        this.parser = parser;
        return this;
    }

    public ConfigParser getParser() {
        return parser;
    }

    public static Configuration classpath(String config) {
        ClasspathConfigSource source = new ClasspathConfigSource(config);
        ConfigParser parser = ConfigParser.Parsers.createParser(getExtension(config));
        return create().withSource(source).withParser(parser);
    }

    private static String getExtension(String config) {
        String[] split = config.split("\\.");
        return split[split.length - 1];
    }
}
