package analizadorproyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws Exception {
//        String ruta1 = "C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/src/analizadorproyecto/Lexer.flex";
//        String ruta2 = "C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/src/analizadorproyecto/LexerCup.flex";
//        String[] rutaS = {"-parser", "Sintax", "C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/src/analizadorproyecto/Sintax.cup"};
//        generar(ruta1, ruta2, rutaS);
//    }
//    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
//        File archivo;
//        archivo = new File(ruta1);
//        JFlex.Main.generate(archivo);
//        archivo = new File(ruta2);
//        JFlex.Main.generate(archivo);
//        java_cup.Main.main(rutaS);
//
//        Path rutaSym = Paths.get("C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/src/analizadorproyecto/sym.java");
//        if (Files.exists(rutaSym)) {
//            Files.delete(rutaSym);
//        }
//        Files.move(
//                Paths.get("C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/sym.java"),
//                Paths.get("C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/src/analizadorproyecto/sym.java")
//        );
//        Path rutaSin = Paths.get("C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/src/analizadorproyecto/Sintax.java");
//        if (Files.exists(rutaSin)) {
//            Files.delete(rutaSin);
//        }
//        Files.move(
//                Paths.get("C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/Sintax.java"),
//                Paths.get("C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/src/analizadorproyecto/Sintax.java")
//        );

       String rutaLexer = "C:/Users/Cynde/OneDrive/Documentos/NetBeansProjects/AnalizadorProyecto/src/analizadorproyecto/Lexer.flex";

        // Leer Lexer.flex e interpretarlo para generar la tabla de símbolos
        TablaDeSimbolos tablaSimbolos = generarTablaSimbolos(rutaLexer);

        // Imprimir la tabla de símbolos (solo como ejemplo)
        tablaSimbolos.imprimirTabla();
    }

    public static TablaDeSimbolos generarTablaSimbolos(String rutaLexer) throws IOException {
        TablaDeSimbolos tablaSimbolos = new TablaDeSimbolos();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaLexer))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                analizarLinea(linea, tablaSimbolos);
            }
        }

        return tablaSimbolos;
    }

   public static void analizarLinea(String linea, TablaDeSimbolos tablaSimbolos) {
    // Buscar patrones de tokens en la línea y agregar a la tabla de símbolos
    if (linea.contains("return")) {
        String[] tokens = linea.split(" ");
        Simbolo simbolo = new Simbolo();

        for (String token : tokens) {
            if (token.matches("[A-Za-z_]+")) {
                String nombre = token;
                tablaSimbolos.agregarSimbolo(nombre, simbolo);
            } else if (token.equals("int") || token.equals("string") || token.equals("void") || /*... Otros tipos*/) {
                simbolo.setTipo(token);
            } else if (token.equals("public") || token.equals("private") || token.equals("protected")) {
                simbolo.setVisibilidad(token);
            }
            // Puedes seguir extendiendo esta lógica para los demás atributos como Ambito, Tamaño/Valor, Posicion, Rol, etc.
        }
}
