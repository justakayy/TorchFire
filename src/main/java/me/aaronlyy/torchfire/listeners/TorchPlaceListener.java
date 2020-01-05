//
// Project: TorchFire | Package: me.aaronlyy.torchfire.listeners
// by aaronlyy 2020
//

package me.aaronlyy.torchfire.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class TorchPlaceListener implements Listener {

    @EventHandler
    public void onTorchPlace(BlockPlaceEvent e){

        if (e.getBlockPlaced().getType() == Material.TORCH || e.getBlockPlaced().getType() == Material.WALL_TORCH){

            Location torchLocation = e.getBlockPlaced().getLocation();
            World world = torchLocation.getWorld();
            int locX = torchLocation.getBlockX();
            int locY = torchLocation.getBlockY();
            int locZ = torchLocation.getBlockZ();

            Location blockAboveLocation = new Location(world, locX, locY + 1, locZ );
            Block blockAbove = blockAboveLocation.getBlock();

            if (blockAbove.getType().isFlammable() || blockAbove.getType().isBurnable()){
                if (blockAbove.getRelative(BlockFace.UP).getType() == Material.AIR){
                    // TODO: add delay
                    blockAbove.getRelative(BlockFace.UP).setType(Material.FIRE);
                }
            }
        }
    }
}
