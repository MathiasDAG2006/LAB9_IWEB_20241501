package Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    // Usamos un metodo estatico para poder convertir cualquier texto plano a su HASH
    public static String convertirHash(String texto) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Convertimos los bytes de texto plano UTF-8 a los bytes usados para el hash
            byte[] hashBytes = md.digest(texto.getBytes(StandardCharsets.UTF_8));

            StringBuilder string = new StringBuilder();

            // Hasheamos por cada uno de los bytes
            for (byte b : hashBytes) {
                String bitHash = Integer.toHexString(0xff & b);

                string.append(bitHash);
            }

            // Devolvemos el hash
            return string.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al cifrar la constraseña");
        }

    }
}










