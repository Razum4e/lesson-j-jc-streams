package lessons.javaCore.streams.unSerialAndUnZip;

import lessons.javaCore.streams.install.GameProgress;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static final String PATH = "C:\\Users\\Asus\\Documents\\JavaProjects\\ProjectRazumov\\src\\lessons\\javaCore\\streams\\Games\\savegames";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        unZip("convert.zip");

        List<String> pathTxt = new ArrayList<>();
        pathTxt.add("save1.txt");
        pathTxt.add("save2.txt");
        pathTxt.add("save3.txt");

        List<GameProgress> gameProgress = unSerializable(pathTxt);
        for (GameProgress progress : gameProgress) {
            System.out.println(progress);
        }

    }

    public static void unZip(String nameZip) throws IOException {

        ZipInputStream zis = new ZipInputStream(new FileInputStream(PATH + "\\" + nameZip));
        ZipEntry entry;
        String name;
        while ((entry = zis.getNextEntry()) != null) {
            name = entry.getName();
            FileOutputStream fos = new FileOutputStream(PATH + "\\" + name);
            for (int c = zis.read(); c != -1; c = zis.read()) {
                fos.write(c);
            }
            fos.flush();
            zis.closeEntry();
            fos.close();
        }
    }

    public static List<GameProgress> unSerializable(List<String> pathTxt) throws IOException, ClassNotFoundException {
        List<GameProgress> gameProgress = new ArrayList<>();
        for (String path : pathTxt) {
            FileInputStream fis = new FileInputStream(PATH + "\\" + path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            GameProgress progress = (GameProgress) ois.readObject();
            gameProgress.add(progress);
            ois.close();
            fis.close();
        }
        return gameProgress;
    }
}
