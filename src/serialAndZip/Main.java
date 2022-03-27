package lessons.javaCore.streams.src.serialAndZip;

import lessons.javaCore.streams.src.install.GameProgress;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static final String PATH = "C:\\Users\\Asus\\Documents\\JavaProjects\\ProjectRazumov\\src\\lessons\\javaCore\\streams\\Games\\savegames";

    public static void main(String[] args) throws IOException {
        List<File> pathTxt = new ArrayList<>();

        GameProgress save1 = new GameProgress(100, 8, 20, 123.1);
        GameProgress save2 = new GameProgress(80, 4, 35, 200.2);
        GameProgress save3 = new GameProgress(50, 10, 85, 4000.1);

        File save1_txt = new File(PATH + "\\save1.txt");
        save1_txt.createNewFile();
        pathTxt.add(save1_txt);
        File save2_txt = new File(PATH + "\\save2.txt");
        save2_txt.createNewFile();
        pathTxt.add(save2_txt);
        File save3_txt = new File(PATH + "\\save3.txt");
        save3_txt.createNewFile();
        pathTxt.add(save3_txt);

        saveGame(save1_txt, save1);
        saveGame(save2_txt, save2);
        saveGame(save3_txt, save3);

        convertInZip(pathTxt, "convert.zip");

    }

    public static void saveGame(File path, GameProgress save) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertInZip(List<File> pathTxt, String nameZip) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(PATH + "\\" + nameZip));
        for (File path : pathTxt) {
            FileInputStream fis = new FileInputStream(path);
            ZipEntry entry = new ZipEntry(path.getName());
            zos.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zos.write(buffer);
            zos.closeEntry();
            fis.close();
            path.delete();
        }
        zos.close();
    }
}
