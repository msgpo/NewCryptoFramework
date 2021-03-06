package com.vandenbreemen.mobilesecurestorage.cache;

import com.vandenbreemen.mobilesecurestorage.security.Entropy;

/**
 * <h2>Intro</h2>
 * <p>
 * <h2>Other Details</h2>
 *
 * @author kevin
 */
public class CachedByteData {

    private volatile byte[] data;

    public CachedByteData(byte[] data) {
        this.data = data;
    }

    @Override
    public void finalize() {
        Entropy.get().fillBytes(data);
        data = null;
    }

    public byte[] getData() {
        return data;
    }
}
