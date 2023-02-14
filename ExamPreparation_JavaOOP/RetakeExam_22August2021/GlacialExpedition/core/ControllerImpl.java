package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.models.suitcases.Suitcase;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private Mission mission;

    private int exploredStatesCount;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;
        if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else {
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State stateToAdd = new StateImpl(stateName);
        stateToAdd.getExhibits().addAll(List.of(exhibits));
        this.stateRepository.add(stateToAdd);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        if (this.explorerRepository.getCollection().stream().noneMatch(e -> e.getName().equals(explorerName))) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        } else {
            Explorer explorerToRetire = this.explorerRepository
                    .getCollection()
                    .stream()
                    .filter(e -> e.getName().equals(explorerName))
                    .findFirst().get();
            this.explorerRepository.remove(explorerToRetire);
        }
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        //todo exploredStatesCount++

        List<Explorer> explorerList = this.explorerRepository
                .getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        if (explorerList.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        return String.format(STATE_EXPLORER, stateName, explorerList.size());
    }

    @Override
    public String finalResult() {
        StringBuilder output = new StringBuilder();

        output.append(String.format(FINAL_STATE_EXPLORED, exploredStatesCount))
                .append(System.lineSeparator())
                .append(FINAL_EXPLORER_INFO)
                .append(System.lineSeparator());
        this.explorerRepository
                .getCollection()
                .forEach(currentExplorer ->
                {
                    output.append(String.format(FINAL_EXPLORER_NAME, currentExplorer.getName()))
                            .append(System.lineSeparator())
                            .append(String.format(FINAL_EXPLORER_ENERGY, currentExplorer.getEnergy()))
                            .append(System.lineSeparator());
                    if (currentExplorer.getSuitcase().getExhibits().isEmpty()) {
                        output.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"))
                                .append(System.lineSeparator());
                    } else {
                        currentExplorer.getSuitcase().getExhibits().forEach(
                                suitcaseExhibits -> {
                                    output.append(String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,
                                                    FINAL_EXPLORER_SUITCASE_EXHIBITS, suitcaseExhibits))
                                            .append(System.lineSeparator());
                                });
                    }
                });
        return output.toString().trim();
    }
}
