/*
 * This source file is part of the Epistemics of the Virtual software.
 * It was created by:
 * Johan F. Hoorn - theoretical model and algorithms
 * Henri Zwols - software design and engineering
 */
package selemca.epistemics.mentalworld.engine.metaphor;

import selemca.epistemics.data.entity.Concept;

/**
 * Created by henrizwols on 25-05-15.
 */
public interface MetaphorProcessor {
    public enum MetaphorAssesment {
        LITERAL, METAPHOR, ANOMALY
    };

    MetaphorAssesment assesRelation(Concept concept1, Concept concept2);
}
