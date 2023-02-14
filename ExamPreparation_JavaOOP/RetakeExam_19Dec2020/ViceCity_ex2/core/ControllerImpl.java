package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.BasePlayer;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Queue<Gun> gunsQueue;
    private List<Player> civilPlayers;
    private Player mainPlayer;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.gunsQueue = new ArrayDeque<>();
        this.civilPlayers = new ArrayList<>();
        this.mainPlayer = new MainPlayer();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player currentCivilPlayer = new CivilPlayer(name);
        civilPlayers.add(currentCivilPlayer);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
            gunsQueue.offer(gun);
            return String.format(GUN_ADDED, name, type);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
            gunsQueue.offer(gun);
            return String.format(GUN_ADDED, name, type);
        } else {
            return GUN_TYPE_INVALID;
        }
    }

    @Override
    public String addGunToPlayer(String name) {
        if (gunsQueue.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        } else if (name.equals("Vercetti")) {
            Gun gunToAdd = gunsQueue.peek();
            mainPlayer.getGunRepository().add(gunToAdd);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gunsQueue.poll().getName(), mainPlayer.getName());
        } else if (civilPlayers.stream().noneMatch(p -> p.getName().equals(name))) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        } else {
            Gun gunToAdd = gunsQueue.peek();
            civilPlayers.stream().filter(p -> p.getName().equals(name)).findFirst().get().getGunRepository().add(gunToAdd);
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gunsQueue.poll().getName(), name);
        }
    }

    @Override
    public String fight() {

        int mainPlayerPoints = mainPlayer.getLifePoints();
        int civilPlayersPoints = civilPlayers.stream().mapToInt(Player::getLifePoints).sum();
        int countPlayers = civilPlayers.size();
        neighbourhood.action(mainPlayer, civilPlayers);
        boolean pointsEquals = civilPlayersPoints == civilPlayers.stream().mapToInt(Player::getLifePoints).sum();

        if (mainPlayerPoints == mainPlayer.getLifePoints() && pointsEquals) {
            return FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder output = new StringBuilder();
            output.append(FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, countPlayers - civilPlayers.size()))
                    .append(System.lineSeparator())
                    .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size()));
            return output.toString();
        }
    }
}
