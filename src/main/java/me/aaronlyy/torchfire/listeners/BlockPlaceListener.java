//
// Project: TorchFire | Package: me.aaronlyy.torchfire.listeners
// by aaronlyy 2020
//

package me.aaronlyy.torchfire.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){

        Block blockPlaced = e.getBlockPlaced();

        if (blockPlaced.getType() == Material.TORCH || blockPlaced.getType() == Material.WALL_TORCH){
            /*
            player placed a torch
            set block above torch on fire if possible
            */
            // test if block above torch is burnable or flammable
            Block blockAbove = blockPlaced.getRelative(BlockFace.UP);
            if (blockAbove.getType().isFlammable() || blockAbove.getType().isBurnable()) {
                // set block on fire
                setOnFire(blockAbove);
            }
        }
        else if (blockPlaced.getType().isBurnable() || blockPlaced.getType().isFlammable()){
            /*
            player placed a burnable or flammable block
            set block on fire if possible
            */
            // test if block below is a torch or wall torch
            Block blockBelow = blockPlaced.getRelative(BlockFace.DOWN);
            if (blockBelow.getType() == Material.TORCH || blockBelow.getType() == Material.WALL_TORCH){
                setOnFire(blockPlaced);

                // set block on fire
                setOnFire(blockPlaced);
            }
        }
    }

    private void setOnFire(Block block){
        // set block on fire if material above/north/west/east/south is air

        // FACE UP
        if (block.getRelative(BlockFace.UP).getType() == Material.AIR){
            block.getRelative(BlockFace.UP).setType(Material.FIRE);
        }
        // FACE NORTH
        if (block.getRelative(BlockFace.NORTH).getType() == Material.AIR){
            block.getRelative(BlockFace.NORTH).setType(Material.FIRE);
        }
        // FACE EAST
        if (block.getRelative(BlockFace.EAST).getType() == Material.AIR){
            block.getRelative(BlockFace.EAST).setType(Material.FIRE);
        }
        // FACE WEST
        if (block.getRelative(BlockFace.WEST).getType() == Material.AIR){
            block.getRelative(BlockFace.WEST).setType(Material.FIRE);
        }
        // FACE SOUTH
        if (block.getRelative(BlockFace.SOUTH).getType() == Material.AIR){
            block.getRelative(BlockFace.SOUTH).setType(Material.FIRE);
        }
    }
}
