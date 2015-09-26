package foo;

import java.awt.*;

/**
 * This is an example of a Java class that is difficult to test
 * because there is no way to inject or otherwise mock out its dependencies.
 */
public class ImageResizer {
    /* Where to store resized images */
    public static final String CACHE_DIR = "/var/data";

    /* Maximum number of images to cache before deleting old images */
    private static final int cacheSize =
            Integer.parseInt(System.getProperty("Resizer.cacheSize", "10000"));

    /* Helper to download an image from a URL */
    private final Downloader downloader = new HttpDownloader();

    /* Cache in which to store resized images */
    private final ImageCache cache = new FileImageCache(CACHE_DIR, cacheSize);

    // This class is a singleton
    public static final ImageResizer INSTANCE = new ImageResizer();
    private ImageResizer() {
    }

    public Image getImage(String url, int width, int height) {
        String cacheKey = url + "_" + width + "_" + height;

        // First look in the cache
        Image cached = cache.get(cacheKey);
        if (cached != null) {
            // Cache hit
            return cached;
        } else {
            // Cache miss. Download the image, resize it and cache the result.
            byte[] original = downloader.get(url);
            Image resized = resize(original, width, height);
            cache.put(cacheKey, resized);
            return resized;
        }
    }

    private Image resize(byte[] original, int width, int height) {
        // ...
        return null;
    }
}

interface Downloader {
    byte[] get(String url);
}

class HttpDownloader implements Downloader {
    public HttpDownloader() {
    }

    @Override
    public byte[] get(String url) {
        return new byte[0];
    }
}

interface ImageCache {
    Image get(String key);
    void put(String key, Image value);
}

class FileImageCache implements ImageCache {
    public FileImageCache(String dataDir, int maxSize) {

    }

    @Override
    public Image get(String key) {
        return null;
    }

    @Override
    public void put(String key, Image value) {

    }
}
