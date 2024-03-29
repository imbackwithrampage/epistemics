/*
 * This source file is part of the Epistemics of the Virtual software.
 * It was created by:
 * Johan F. Hoorn - theoretical model and algorithms
 * Henri Zwols - software design and engineering
 */
package selemca.epistemics.mentalworld.engine.deriver.appraisal;

import org.apache.commons.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import selemca.epistemics.mentalworld.engine.MentalWorldEngine;
import selemca.epistemics.mentalworld.engine.factory.DeriverNodeFactory;
import selemca.epistemics.mentalworld.engine.node.EpistemicAppraisalDeriverNode;
import selemca.epistemics.mentalworld.engine.realitycheck.RealityCheck;
import selemca.epistemics.mentalworld.engine.workingmemory.WorkingMemory;

@Component
public class EpistemicAppraisalDeriverNodeFactory implements DeriverNodeFactory<EpistemicAppraisalDeriverNode> {
    private static final String CONFIGURATION_NAME = "epistemicAppraisalDeriver.default";

    @Autowired
    private Configuration configuration;

    @Autowired
    private RealityCheck realityCheck;

    @Override
    public Class<EpistemicAppraisalDeriverNode> getDeriverNodeClass() {
        return EpistemicAppraisalDeriverNode.class;
    }

    @Override
    public String getName() {
        return CONFIGURATION_NAME;
    }

    @Override
    public EpistemicAppraisalDeriverNode createDeriverNode(WorkingMemory workingMemory, MentalWorldEngine.Logger logger) {
        return new DefaultEpistemicAppraisalDeriverNode(workingMemory, logger, realityCheck, configuration);
    }
}
