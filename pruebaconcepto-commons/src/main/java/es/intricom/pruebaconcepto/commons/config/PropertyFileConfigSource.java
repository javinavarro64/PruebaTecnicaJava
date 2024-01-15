package es.intricom.pruebaconcepto.commons.config;

import org.eclipse.microprofile.config.spi.ConfigSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * Implementación del ConfigSource para obtener propiedades de configuración a partir de los fichero
 * que se tienen que encontrar a la ruta indicada a las propiedades de sistema indicadas al estándar (Apartado 3.5.2)
 * Esta clase se registra dentro del fichero META-INF/services/org.eclipse.microprofile.config.spi.ConfigSource
 */
public class PropertyFileConfigSource implements ConfigSource {

    private static final Logger LOG = LoggerFactory.getLogger(PropertyFileConfigSource.class);

    private static final String[] FILE_NAME_PROPERTIES = {
            "es.intricom.pruebaconcepto.properties",
            "es.intricom.pruebaconcepto.system.properties"
    };

    private static final Map<String, String> PROPERTY_MAP;

    static {
        LOG.info("Cargando propiedades de configuración.... ");

        Map<String, String> propertyMap = new HashMap<>();
        for (String fileNameProperty : FILE_NAME_PROPERTIES) {
            LOG.info("Comprobando la propiedad: {}", fileNameProperty);

            String propertyFile = System.getProperty(fileNameProperty);
            if (propertyFile == null || propertyFile.isEmpty()) {
                throw new RuntimeException("Falta la propiedad de sistema " + fileNameProperty);
            }
            LOG.info("Fichero de propiedades: {}", propertyFile);

            Properties properties = new Properties();
            try (Reader reader = new FileReader(propertyFile, StandardCharsets.UTF_8)) {
                properties.load(reader);
            } catch (IOException exception) {
                throw new RuntimeException("Error leyendo el fichero " + propertyFile, exception);
            }

            properties.stringPropertyNames().forEach(
                    x -> propertyMap.put(x, properties.getProperty(x))
            );
        }

        PROPERTY_MAP = Collections.unmodifiableMap(propertyMap);
    }

    public PropertyFileConfigSource() {
    }

    @Override
    public Set<String> getPropertyNames() {
        return PROPERTY_MAP.keySet();
    }

    @Override
    public int getOrdinal() {
        return ConfigSource.DEFAULT_ORDINAL;
    }

    @Override
    public Map<String, String> getProperties() {
        return PROPERTY_MAP;
    }

    @Override
    public String getValue(String key) {
        return PROPERTY_MAP.get(key);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
