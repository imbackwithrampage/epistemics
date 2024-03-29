/*
 * This source file is part of the Epistemics of the Virtual software.
 * It was created by:
 * Johan F. Hoorn - theoretical model and algorithms
 * Henri Zwols - software design and engineering
 */
package selemca.epistemics.mentalworld.engine.deriver.integratordeviation;

import org.apache.commons.configuration.Configuration;
import selemca.epistemics.data.entity.Concept;
import selemca.epistemics.mentalworld.engine.MentalWorldEngine;
import selemca.epistemics.mentalworld.engine.category.CategoryMatch;
import selemca.epistemics.mentalworld.engine.node.IntegratorDeviationDeriverNode;
import selemca.epistemics.mentalworld.engine.workingmemory.WorkingMemory;

import static selemca.epistemics.mentalworld.engine.deriver.integratordeviation.IntegratorDeviationDeriverNodeSettingsProvider.INTEGRATOR_DEVIATION_CRITERION;
import static selemca.epistemics.mentalworld.engine.workingmemory.AttributeKind.CATEGORY_MATCH;
import static selemca.epistemics.mentalworld.engine.workingmemory.AttributeKind.CONCEPT;
import static selemca.epistemics.mentalworld.engine.workingmemory.AttributeKind.CONTRIBUTOR;

public class DefaultIntegratorDeviationDeriverNodeImpl implements IntegratorDeviationDeriverNode {
    final double DEVIATION_CRITERION_DEFAULT = 0.4;

    private final WorkingMemory workingMemory;
    private final MentalWorldEngine.Logger logger;
    private final double criterion;

    public DefaultIntegratorDeviationDeriverNodeImpl(WorkingMemory workingMemory, MentalWorldEngine.Logger logger, Configuration applicationSettings) {
        this.workingMemory = workingMemory;
        this.logger = logger;
        this.criterion = applicationSettings.getDouble(INTEGRATOR_DEVIATION_CRITERION, DEVIATION_CRITERION_DEFAULT);
    }

    @Override
    public boolean decide() {
//        Concept concept = workingMemory.get(CONCEPT);
        Concept contribution = workingMemory.get(CONTRIBUTOR);
        CategoryMatch categoryMatch = workingMemory.get(CATEGORY_MATCH);
        boolean result = categoryMatch.getContributorScore(contribution) >= criterion;
        logger.info("Willing to deviate: " + result);
        return result;
    }

    @Override
    public boolean isWillingToDeviate(Concept concept, Concept contribution) {
        workingMemory.set(CONCEPT, concept);
        workingMemory.set(CONTRIBUTOR, contribution);
        return decide();
    }
}
