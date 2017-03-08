package me.totalfreedom.totalfreedommod.command;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Run your personal command.", usage = "/<command>", aliases = "psl")
public class Command_personal extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        String which;
        if (args.length >= 1)
        {
            if (!ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()) && !sender.getName().equals("tylerhyperHD"))
            {
                FUtil.playerMsg(sender, "You do not have permission to perform this command.", ChatColor.RED);
                return true;
            }
            which = args[0];
        }
        else if (sender.getName().equals("eagleeye64000") || sender.getName().equals("R1SSY") || sender.getName().equals("escojay"))
        {
            which = "multiEagle";
        }
        else
        {
            which = sender_p.getName();
        }
        switch (which)
        {
            case "Camzie99":
                break;
            case "jumpymonkey123":
                FUtil.asciiUnicorn();
                break;
            case "tylerhyperHD":
                FUtil.adminAction(ChatColor.RED + sender.getName(), ChatColor.WHITE + "" + ChatColor.BOLD + "BEHOLD! THE " + ChatColor.BLACK + "" + ChatColor.BOLD + "LIE " + ChatColor.WHITE + "" + ChatColor.BOLD + "GOD!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack trip = new ItemStack(Material.CAKE, 1);
                    ItemMeta meta = trip.getItemMeta();
                    meta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "THE " + ChatColor.BLACK + "" + ChatColor.BOLD + "LIE " + ChatColor.WHITE + "" + ChatColor.BOLD + "GOD");
                    trip.setItemMeta(meta);
                    inv.addItem(trip);
                }
                for (World world : Bukkit.getWorlds())
                {
                    for (Entity entity : world.getEntities())
                    {
                        if (entity instanceof LivingEntity && !(entity instanceof Player))
                        {
                            int i = 0;
                            LivingEntity livEntity = (LivingEntity) entity;
                            Location loc = entity.getLocation();
                            do
                            {
                                world.strikeLightningEffect(loc);

                                i++;
                            } while (i <= 2);
                            livEntity.setHealth(0);
                        }
                    }
                    for (final Player player : server.getOnlinePlayers())
                    {
                        for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS))
                        {
                            final float pitch = (float) (percent * 2.0);

                            new BukkitRunnable()
                            {
                                @Override
                                public void run()
                                {
                                    player.playSound(randomOffset(player.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                                }
                            }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
                        }
                    }
                }
                break;
            case "Alex33856":
                Player sender_alex = Bukkit.getPlayer(sender.getName());
                FUtil.adminAction(sender_alex.getName(), "Casting Doom All Over the World", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    FUtil.bcastMsg(player.getName() + " has been a naughty, naughty boy.", ChatColor.GREEN);
                    final Location targetPos = player.getLocation();
                    final World world = player.getWorld();
                    for (int x = -1; x <= 1; x++)
                    {
                        for (int z = -1; z <= 1; z++)
                        {
                            final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                            world.strikeLightning(strike_pos);
                        }
                    }
                }
                FUtil.bcastMsg("Alex33856 - Has taken over the world!", ChatColor.RED);
                break;
            case "Dragonfire147":
                FUtil.asciiDog();
                FUtil.bcastMsg("hi doggies", FUtil.randomChatColor());
                FUtil.bcastMsg("Now, doggies for everyone :P", ChatColor.AQUA);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    FUtil.spawnMob(player, EntityType.WOLF, 10);
                    LivingEntity dog = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WOLF);
                    dog.setCustomNameVisible(true);
                    dog.setCustomName(ChatColor.DARK_AQUA + "Doggie");
                    player.setOp(true);
                    player.sendRawMessage(FreedomCommand.YOU_ARE_OP);
                }
                break;
            case "cowgomooo12":
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    FUtil.spawnMob(player, EntityType.COW, 2);
                }
                FUtil.adminAction(sender_p.getName(), "Let there be cows!", false);
                break;
            case "Typhlosion147":
                FUtil.bcastMsg("Incoming Oblivion!", ChatColor.RED);
                for (World world : Bukkit.getWorlds())
                {
                    for (Entity entity : world.getEntities())
                    {
                        if (entity instanceof LivingEntity && !(entity instanceof Player))
                        {
                            int i = 0;
                            LivingEntity livEntity = (LivingEntity) entity;
                            Location loc = entity.getLocation();
                            do
                            {
                                world.strikeLightningEffect(loc);

                                i++;
                            } while (i <= 2);
                            livEntity.setHealth(0);
                        }
                    }
                    for (final Player player : server.getOnlinePlayers())
                    {
                        for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS))
                        {
                            final float pitch = (float) (percent * 2.0);

                            new BukkitRunnable()
                            {
                                @Override
                                public void run()
                                {
                                    player.playSound(randomOffset(player.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                                }
                            }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
                        }
                    }
                }
                break;
            case "PieGuy7896":
                FUtil.adminAction(sender_p.getName(), "Pies for all!.", false);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack pie = new ItemStack(Material.PUMPKIN_PIE, 1);
                    ItemMeta meta = pie.getItemMeta();
                    meta.setDisplayName(ChatColor.LIGHT_PURPLE + "FREE PIE");
                    meta.addEnchant(Enchantment.FIRE_ASPECT, 25, true);
                    meta.addEnchant(Enchantment.KNOCKBACK, 10, true);
                    pie.setItemMeta(meta);
                    inv.addItem(pie);
                }
                break;
            case "Rex657":
                FUtil.bcastMsg("Rex is going on a rampage!", ChatColor.RED);
                FUtil.bcastMsg("Take this to kill him!", ChatColor.YELLOW);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                    for (Enchantment ench : Enchantment.values())
                    {
                        sword.addUnsafeEnchantment(ench, 50);
                    }
                    inv.addItem(sword);
                }
                break;
            case "multiEagle":
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack potato = new ItemStack(Material.POTATO_ITEM, 1);
                    ItemMeta meta = potato.getItemMeta();
                    List<String> lore = Arrays.asList(ChatColor.DARK_PURPLE + "It's dangerous to go alone; take this!");
                    meta.setLore(lore);
                    potato.setItemMeta(meta);
                    inv.addItem(potato);
                }
                break;
            case "TheLunarPrincess":
                StringBuilder output = new StringBuilder();
                Random randomGenerator = new Random();

                String[] words = "You have been given a Moonstone from the Moon Princess!".split(" ");
                for (String word : words)
                {
                    String color_code = Integer.toHexString(1 + randomGenerator.nextInt(14));
                    output.append(ChatColor.COLOR_CHAR).append(color_code).append(word).append(" ");
                }
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    FUtil.playerMsg(player, output.toString());
                    PlayerInventory inv = player.getInventory();
                    ItemStack moonstone = new ItemStack(Material.NETHER_STAR, 1);
                    ItemMeta meta = moonstone.getItemMeta();
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "This mysterious stone", ChatColor.BLUE + "was given to you by", ChatColor.GOLD + "the Moon Princess!");
                    meta.setDisplayName(FUtil.randomChatColor() + "" + ChatColor.BOLD + "Moonstone");
                    meta.setLore(lore);
                    moonstone.setItemMeta(meta);
                    inv.addItem(moonstone);
                }
                break;
            case "Dev238":
                FUtil.adminAction(sender.getName(), "You have been DEV'D!!!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    inv.addItem(new ItemStack(Material.SNOW_BALL, 1));
                }
                break;
            case "CrafterSmith12":
                FUtil.adminAction(sender_p.getName(), "Cookies for all! Don't let others take yours!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack cookie = new ItemStack(Material.COOKIE, 1);
                    cookie.addUnsafeEnchantment(Enchantment.KNOCKBACK, 100);
                    ItemMeta meta = cookie.getItemMeta();
                    meta.setDisplayName(ChatColor.GREEN + "Crafter's Cookie!");
                    cookie.setItemMeta(meta);
                    inv.addItem(cookie);
                }
                break;
            case "lukkan99":
                FUtil.adminAction(sender.getName(), "When life gives you lemons, don't make lemonade! Make life take the lemons back! Get mad!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack glados = new ItemStack(Material.POTATO_ITEM, 1);
                    ItemMeta meta = glados.getItemMeta();
                    meta.setDisplayName(FUtil.randomChatColor() + "" + ChatColor.BOLD + "GlaDOS");
                    glados.setItemMeta(meta);
                    inv.addItem(glados);
                }
                break;
            case "robotexplorer":
                FUtil.adminAction(sender_p.getName(), "You think you can outsmart a robot? I think NOT!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack robot = new ItemStack(Material.REDSTONE_BLOCK, 1);
                    ItemMeta meta = robot.getItemMeta();
                    meta.setDisplayName(ChatColor.RED + "Robot");
                    robot.setItemMeta(meta);
                    inv.addItem(robot);
                }
                break;
            case "GigaByte_Jr":
                FUtil.asciiDog();
                FUtil.adminAction(sender_p.getName(), "Giving everyone a pet Woofie.\nTame them with the bone!", false);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    inv.addItem(new ItemStack(Material.BONE, 1));
                    LivingEntity dog = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WOLF);
                    dog.setCustomNameVisible(true);
                    dog.setCustomName(ChatColor.DARK_AQUA + "Woofie!");
                }
                break;
            case "DeerBoo":
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    inv.addItem(new ItemStack(Material.COOKIE, 1));
                    FUtil.adminAction(sender_p.getName(), "There you go my deer", true);
                }
                break;
            case "Ninjaristic":
                FUtil.asciiHorse();
                FUtil.bcastMsg("NEIGH", ChatColor.RED);
                break;
            case "0sportguy0":
                FUtil.adminAction(sender_p.getName(), "An apple a day keeps the doctor away!", false);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1));
                }
                break;
            case "SupItsDillon":
                FUtil.bcastMsg("Pingu is love, Pingu is life.", ChatColor.RED);
                for (Player player : server.getOnlinePlayers())
                {
                    ItemStack heldItem = new ItemStack(Material.COOKIE);
                    ItemMeta heldItemMeta = heldItem.getItemMeta();
                    heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("Pingu is Love ").append(ChatColor.BLACK).append("Pingu is Life").toString());
                    heldItem.setItemMeta(heldItemMeta);

                    player.getInventory().setItem(player.getInventory().firstEmpty(), heldItem);
                }
                break;
            case "lynxlps":
                FUtil.adminAction("Dahlia Hawthorne", "Eliminating all signs of life.", true);
                for (World world : Bukkit.getWorlds())
                {
                    for (Entity entity : world.getEntities())
                    {
                        if (entity instanceof LivingEntity && !(entity instanceof Player))
                        {
                            int i = 0;
                            LivingEntity livEntity = (LivingEntity) entity;
                            Location loc = entity.getLocation();
                            do
                            {
                                world.strikeLightningEffect(loc);

                                i++;
                            } while (i <= 2);
                            livEntity.setHealth(0);
                        }
                    }
                    for (final Player player : server.getOnlinePlayers())
                    {
                        for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS))
                        {
                            final float pitch = (float) (percent * 2.0);

                            new BukkitRunnable()
                            {
                                @Override
                                public void run()
                                {
                                    player.playSound(randomOffset(player.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                                }
                            }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
                        }
                    }
                }
                break;
            case "samennis1":
                FUtil.adminAction(sender_p.getName(), "Getting ready to power up!", true);
                FUtil.adminAction(sender_p.getName(), "POWERED UP!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemMeta meta = dsword.getItemMeta();
                    meta.setDisplayName(ChatColor.DARK_RED + "Magic " + ChatColor.DARK_AQUA + "Power");
                    dsword.setItemMeta(meta);
                    inv.addItem(dsword);
                }
                break;
            case "Lehctas":
                FUtil.adminAction(sender_p.getName(), "Giving everyone a wand that doesn't work", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack wand = new ItemStack(Material.STICK, 1);
                    ItemMeta meta = wand.getItemMeta();
                    meta.setDisplayName(ChatColor.DARK_PURPLE + "Void Wand");
                    List<String> lore = Arrays.asList(ChatColor.BLUE + "Void wand given by Lehctas, You wish you can use it. But haha. nerd. You can't only Lehctas can!");
                    meta.setLore(lore);
                    wand.setItemMeta(meta);
                    inv.addItem(wand);
                }
            case "aggelosQQ":
                FUtil.adminAction(sender_p.getName(), "Giving everyone a free egg! EGG FIGHT!", true);
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    PlayerInventory inv = player.getInventory();
                    ItemStack egg = new ItemStack(Material.EGG, 1);
                    ItemMeta meta = egg.getItemMeta();
                    meta.setDisplayName(ChatColor.DARK_GREEN + "eggelosQQ's" + ChatColor.AQUA + "Egg");
                    meta.addEnchant(Enchantment.KNOCKBACK, 320, true);
                    egg.setItemMeta(meta);
                    inv.addItem(egg);
                }
                break;
            default:
                FUtil.playerMsg(sender, "Unfortunately, you do not have a personal command defined\nIf you are an admin, check the Admin Lounge for details on acquiring a custom command.", ChatColor.AQUA);
                break;
        }
        return true;
    }

    private static final Random random = new Random();
    public static final double STEPS = 10.0;

    private static Location randomOffset(Location a, double magnitude)
    {
        return a.clone().add(randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude);
    }

    private static Double randomDoubleRange(double min, double max)
    {
        return min + (random.nextDouble() * ((max - min) + 1.0));
    }
}
