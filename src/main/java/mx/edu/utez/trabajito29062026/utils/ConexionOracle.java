package mx.edu.utez.trabajito29062026.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionOracle {
    private static final String USUARIO = "";
    private static final String PASSWORD = "";
    private static final String WALLET_PASSWORD = "";
    private static final String NOMBRE_WALLET = "";
    private static final String JDBC_URL = "jdbc:oracle:thin:@" + "";
    private static final String TRUSTSTORE = "truststore.jks";
    private static final String KEYSTORE = "keystore.jks";
    private static ConexionOracle instancia;
    private ConexionOracle() { }
    public static synchronized ConexionOracle getInstancia() {
        if (instancia == null) instancia = new ConexionOracle();
        return instancia;
    }
    public Connection getConnection() throws SQLException {
        return crearConexion();
    }
    private static Connection crearConexion() throws SQLException {
        try { Class.forName("oracle.jdbc.OracleDriver"); }
        catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró ojdbc11. Rebuild del WAR y redeploy en Tomcat.", e);
        }
        String rutaWallet = resolverRutaWallet();
        System.setProperty("javax.net.ssl.trustStore", rutaWallet + "/" + TRUSTSTORE);
        System.setProperty("javax.net.ssl.trustStorePassword", WALLET_PASSWORD);
        System.setProperty("javax.net.ssl.keyStore", rutaWallet + "/" + KEYSTORE);
        System.setProperty("javax.net.ssl.keyStorePassword", WALLET_PASSWORD);
        return DriverManager.getConnection(JDBC_URL, USUARIO, PASSWORD);
    }
    private static String resolverRutaWallet() throws SQLException {
        String envPath = System.getenv("ORACLE_WALLET_PATH");
        if (envPath != null && !envPath.isBlank()) return normalizarRuta(envPath);
        String propPath = System.getProperty("oracle.wallet.path");
        if (propPath != null && !propPath.isBlank()) return normalizarRuta(propPath);
        String rutaClasspath = buscarEnClasspath();
        if (rutaClasspath != null) return rutaClasspath;
        String rutaLocal = System.getProperty("user.dir") + File.separator + NOMBRE_WALLET;
        if (existeWallet(rutaLocal)) return normalizarRuta(rutaLocal);
        throw new SQLException("No se encontró la carpeta " + NOMBRE_WALLET + ".");
    }
    private static String buscarEnClasspath() {
        URL trustStore = ConexionOracle.class.getClassLoader()
                .getResource(NOMBRE_WALLET + "/" + TRUSTSTORE);
        if (trustStore == null || !"file".equals(trustStore.getProtocol())) return null;
        try { return normalizarRuta(Paths.get(trustStore.toURI()).getParent().toString()); }
        catch (URISyntaxException e) { return null; }
    }
    private static boolean existeWallet(String ruta) {
        return new File(ruta, TRUSTSTORE).exists();
    }
    private static String normalizarRuta(String ruta) {
        return ruta.replace("\\", "/");
    }
    public static void main(String[] args) {
        try (Connection conn = ConexionOracle.getInstancia().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT SYSDATE FROM dual")) {
            if (rs.next()) System.out.println("Conexion OK. Fecha del servidor: " + rs.getTimestamp(1));
        } catch (SQLException e) {
            System.err.println("Error de conexion: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
