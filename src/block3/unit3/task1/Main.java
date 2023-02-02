package block3.unit3.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static void createMyRepository(File file, StringBuilder stringBuilder) {
        if (file.mkdir()) {
            stringBuilder.append("Папка ").append(file.getName()).append(" успешно создана.\n");
        } else {
            stringBuilder.append("Папка ").append(file.getName()).append(" не создана.\n");
        }
    }

    private static void createMyFile(File file, StringBuilder stringBuilder) {
        try {
            if (file.createNewFile()) {
                stringBuilder.append("Файл ").append(file.getName()).append(" успешно создан.\n");
            }
        } catch (IOException e) {
            stringBuilder.append("Файл ").append(file.getName()).append(" не создан.\n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();

        File src = new File("E:\\desk top\\homework\\Games", "src");
        createMyRepository(src, result);

        File res = new File("E:\\desk top\\homework\\Games", "res");
        createMyRepository(res, result);

        File saveGames = new File("E:\\desk top\\homework\\Games", "savegames");
        createMyRepository(saveGames, result);

        File temp = new File("E:\\desk top\\homework\\Games", "temp");
        createMyRepository(temp, result);

        File main = new File("E:\\desk top\\homework\\Games\\src", "main");
        createMyRepository(main, result);

        File test = new File("E:\\desk top\\homework\\Games\\src", "test");
        createMyRepository(test, result);

        File mainJava = new File("E:\\desk top\\homework\\Games\\src\\main", "Main.java");
        createMyFile(mainJava, result);

        File utilsJava = new File("E:\\desk top\\homework\\Games\\src\\main", "Utils.java");
        createMyFile(utilsJava, result);

        File dravables = new File("E:\\desk top\\homework\\Games\\res", "dravables");
        createMyRepository(dravables, result);

        File vectors = new File("E:\\desk top\\homework\\Games\\res", "vectors");
        createMyRepository(vectors, result);

        File icons = new File("E:\\desk top\\homework\\Games\\res", "icons");
        createMyRepository(icons, result);

        File tempTxt = new File("E:\\desk top\\homework\\Games\\temp", "temp.txt");
        createMyFile(tempTxt,result);

        FileWriter writer = new FileWriter(tempTxt);
        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();
    }

}
