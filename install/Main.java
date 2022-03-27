package lessons.javaCore.streams.install;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final String PATH = "C:\\Users\\Asus\\Documents\\JavaProjects\\ProjectRazumov\\src\\lessons\\javaCore\\streams";

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        //Games
        File directory = new File(PATH + "\\Games");
        if (directory.mkdir()) sb.append("\\Games loaded" + "\n");
        //Games\src
        File dirSrc = new File(directory, "\\src");
        if (dirSrc.mkdir()) sb.append("\\Games\\src loaded" + "\n");
        if (new File(dirSrc, "\\test").mkdir()) sb.append("\\Games\\src\\test loaded" + "\n");
        //Games\src\main
        File dirSrcMain = new File(dirSrc, "\\main");
        if (dirSrcMain.mkdir()) sb.append("\\Games\\src\\main loaded" + "\n");
        if (new File(dirSrcMain, "Main.java").createNewFile()) sb.append("\\Games\\src\\main\\Main.java loaded" + "\n");
        if (new File(dirSrcMain, "Utils.java").createNewFile())
            sb.append("\\Games\\src\\main\\Utils.java loaded" + "\n");
        //Games\res
        File dirRes = new File(directory, "\\res");
        if (dirRes.mkdir()) sb.append("\\Games\\res loaded" + "\n");
        if (new File(dirRes, "drawables").mkdir()) sb.append("\\Games\\res\\drawables loaded" + "\n");
        if (new File(dirRes, "vectors").mkdir()) sb.append("\\Games\\res\\vectors loaded" + "\n");
        if (new File(dirRes, "icons").mkdir()) sb.append("\\Games\\res\\icons loaded" + "\n");
        //Games\savegames
        if (new File(directory, "\\savegames").mkdir()) sb.append("\\Games\\savegames loaded" + "\n");
        //Games\temp
        File dirTemp = new File(directory, "\\temp");
        if (dirTemp.mkdir()) sb.append("\\Games\\temp loaded" + "\n");
        //Games\temp\temp.txt
        File dirTempTempTxt = new File(dirTemp, "temp.txt");
        if (dirTempTempTxt.createNewFile()) sb.append("\\Games\\temp\\temp.txt loaded" + "\n");

        System.out.println(sb);

        FileWriter writer = new FileWriter(dirTempTempTxt, false);
        writer.write(String.valueOf(sb));
        writer.flush();

    }
}

