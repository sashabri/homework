package block3.unit3.task2and3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

    private static final String locationSaveGamesRepository = "E:\\desk top\\homework\\Games\\savegames";

    private static void saveGame(String location, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(location);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void zipFiles(String zipLocation, List<String> listLocationObject) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipLocation))) {

            int count = 1;
            for (String locationObject : listLocationObject) {
                try (FileInputStream fis = new FileInputStream(locationObject)) {
                    ZipEntry entry = new ZipEntry("save" + count + ".dat");
                    zout.putNextEntry(entry);

                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);

                    zout.write(buffer);
                    zout.closeEntry();
                    count++;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void openZip(String zipInput, String repositoryOutput) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipInput))) {
            ZipEntry entry;
            String name;

            while ((entry = zis.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(repositoryOutput + "\\" + name);
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fout.write(c);
                }
                fout.flush();
                zis.closeEntry();
                fout.close();
            }
        } catch (Exception e) {
        }
    }

    private static GameProgress openProgress(String locationSave) {
        GameProgress gameProgress = null;
        try (FileInputStream fis = new FileInputStream(locationSave);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gameProgress.toString());
        return gameProgress;
    }

    public static void main(String[] args) throws IOException {
        GameProgress progress1 = new GameProgress(45, 50, 30, 125.4);
        GameProgress progress2 = new GameProgress(47, 55, 31, 200.7);
        GameProgress progress3 = new GameProgress(50, 60, 32, 270.5);

        File save1 = new File(locationSaveGamesRepository, "save1.dat");
        save1.createNewFile();
        File save2 = new File(locationSaveGamesRepository, "save2.dat");
        save2.createNewFile();
        File save3 = new File(locationSaveGamesRepository, "save3.dat");
        save3.createNewFile();

        String locationSave1 = locationSaveGamesRepository + "\\save1.dat";
        String locationSave2 = locationSaveGamesRepository + "\\save2.dat";
        String locationSave3 = locationSaveGamesRepository + "\\save3.dat";

        saveGame(locationSave1, progress1);
        saveGame(locationSave2, progress2);
        saveGame(locationSave3, progress3);

        File zip = new File(locationSaveGamesRepository, "zip.zip");
        zip.createNewFile();

        List<String> locations = new ArrayList<>();
        locations.add(locationSave1);
        locations.add(locationSave2);
        locations.add(locationSave2);

        zipFiles(locationSaveGamesRepository + "\\zip.zip", locations);

        save1.delete();
        save2.delete();
        save3.delete();

        openZip(locationSaveGamesRepository + "\\zip.zip", locationSaveGamesRepository);

        openProgress(locationSave1);
        openProgress(locationSave2);
        openProgress(locationSave3);
    }
}
