import java.util.Random;

class FileDownloader implements Runnable {

    private String fileName;
    private Random random = new Random();

    public FileDownloader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int progress = 0; progress <= 100; progress += 25) {
            try {
                Thread.sleep(500 + random.nextInt(500));
            } catch (InterruptedException e) {
                System.out.println("Download interrupted");
            }
            System.out.println("[" + Thread.currentThread().getName() +
                    "] Downloading " + fileName + ": " + progress + "%");
        }
    }
}

public class DownloadManager {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new FileDownloader("Document.pdf"));
        Thread t2 = new Thread(new FileDownloader("Image.jpg"));
        Thread t3 = new Thread(new FileDownloader("Video.mp4"));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}
