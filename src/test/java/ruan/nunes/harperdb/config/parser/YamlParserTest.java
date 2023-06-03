package ruan.nunes.harperdb.config.parser;

import ruan.nunes.harperdb.config.ConfigModel;
import ruan.nunes.harperdb.config.source.ClasspathConfigSource;
import ruan.nunes.harperdb.config.source.ConfigSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YamlParserTest {

//    @Test
//    void testParse() {
//        YamlParser yamlParser = new YamlParser();
//        ConfigSource source = new ClasspathConfigSource("harperdb.yaml");
//        ConfigModel configModel = yamlParser.parse(source);
//
//        assertEquals(9956, configModel.getAsInt("server.node1.port"));
//        assertEquals("localhost", configModel.getAsString("server.node1.host"));
//        assertEquals(9957, configModel.getAsInt("server.node2.port"));
//        assertEquals("127.0.0.1", configModel.getAsString("server.node2.host"));
//    }

    @Test
    void testParse_NonExistingFile() {
        YamlParser yamlParser = new YamlParser();
        ConfigSource source = new ClasspathConfigSource("harperdb1.yaml");
        ConfigModel configModel = yamlParser.parse(source);

        assertNotNull(configModel);
        assertTrue(configModel.getAsMap().isEmpty());
    }
}