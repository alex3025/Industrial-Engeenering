package com.indeng.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import net.minecraft.entity.item.EntityMinecart;

public class Train {
	private final UUID uuid;
    private final Set<UUID> carts = new HashSet<UUID>();
    private final Set<UUID> safeSet = Collections.unmodifiableSet(carts);
    private final Set<UUID> lockingTracks = new HashSet<UUID>();

    public Train(EntityMinecart cart) {
        uuid = UUID.randomUUID();
    }

    public UUID getUUID() {
        return uuid;
    }

    public boolean containsCart(EntityMinecart cart) {
        if (cart == null) {
            return false;
        }
        return carts.contains(cart.getPersistentID());
    }

    public Set<UUID> getCartsInTrain() {
        return safeSet;
    }

    public int getSize() {
        return carts.size();
    }

    public boolean isTrainLockedDown() {
        return !lockingTracks.isEmpty();
    }

    public void addLockingTrack(UUID track) {
        lockingTracks.add(track);
    }

    public void removeLockingTrack(UUID track) {
        lockingTracks.remove(track);
    }

    
}
