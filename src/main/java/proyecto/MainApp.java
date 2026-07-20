package proyecto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::crearVentana);
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Listas Circulares — EDA 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(1280, 800));
        frame.setMinimumSize(new Dimension(900, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Platform.runLater(() -> initWebView(fxPanel));
    }

    private static void initWebView(JFXPanel fxPanel) {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        URL html = MainApp.class.getResource("/listas_circulares.html");
        if (html == null) {
            engine.loadContent(
                "<html><body style='font-family:sans-serif;padding:40px'>"
                + "<h2>No se encontró listas_circulares.html</h2>"
                + "<p>Asegúrate de que el archivo esté empaquetado dentro del JAR.</p>"
                + "</body></html>"
            );
        } else {
            engine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
                if (newState == Worker.State.FAILED) {
                    Throwable ex = engine.getLoadWorker().getException();
                    String msg = ex != null ? ex.getMessage() : "Error desconocido";
                    engine.loadContent(
                        "<html><body style='font-family:sans-serif;padding:40px'>"
                        + "<h2>Error al cargar la interfaz</h2>"
                        + "<p>" + msg + "</p></body></html>"
                    );
                }
            });
            engine.load(html.toExternalForm());
        }

        fxPanel.setScene(new Scene(webView));
    }
}
