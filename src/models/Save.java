package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Save {
    public static void salvar(String file_name, String ext, String info) {

        try {
            // Pega a pasta do log
            File path_log = new File("./src/files");
            // Monta o path e nome do arquivo de acordo com a quantidade
            String new_file_name = path_log.toString() + "\\" + file_name + ext;
            // Monta o objeto do arquivo e salva
            FileWriter file = new FileWriter(new_file_name);
            BufferedWriter arq = new BufferedWriter(file);
            arq.write(info);
            arq.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void compactar(String file_name, String ext, String cabecalho, String palavraCript) {
        try {
            // Pega a pasta do log
            File path_log = new File("./src/files");
            // Monta o path e nome do arquivo de acordo com a quantidade
            String new_file_name = path_log.toString() + "\\" + file_name + ext;
            // Monta o objeto do arquivo e salva
            FileWriter file = new FileWriter(new_file_name);
            BufferedWriter arq = new BufferedWriter(file);
            arq.write(cabecalho);
            arq.write("\n");
            arq.write(palavraCript);
            arq.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
