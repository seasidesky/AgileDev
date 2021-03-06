/**
 * Copyright (C) 2014 uniknow. All rights reserved.
 * 
 * This Java class is subject of the following restrictions:
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * 3. The end-user documentation included with the redistribution, if any, must
 * include the following acknowledgment: "This product includes software
 * developed by uniknow." Alternately, this acknowledgment may appear in the
 * software itself, if and wherever such third-party acknowledgments normally
 * appear.
 * 
 * 4. The name ''uniknow'' must not be used to endorse or promote products
 * derived from this software without prior written permission.
 * 
 * 5. Products derived from this software may not be called ''UniKnow'', nor may
 * ''uniknow'' appear in their name, without prior written permission of
 * uniknow.
 * 
 * THIS SOFTWARE IS PROVIDED ''AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL WWS OR ITS
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.uniknow.agiledev.junitbdd.internal.domain;

import static org.junit.Assert.*;
import static org.uniknow.agiledev.junitbdd.BDD.*;

import org.junit.runner.*;

import org.uniknow.agiledev.junitbdd.Scenario;
import org.uniknow.agiledev.junitbdd.BDDRunner;
import org.uniknow.agiledev.junitbdd.internal.domain.ScenarioModel.ScenarioStatus;

@RunWith(BDDRunner.class)
public class StoryStatisticsScenarios {
    @Scenario
    public void shouldCountNumberOfPassedFailedAndPendingScenarios() {
        Given("Story with three scenarios: one passing, one failing, and one pending");
        StoryModel story = new StoryModel();
        story.addScenario(new ScenarioModel("passing")
            .withStatus(ScenarioStatus.PASSED));
        story.addScenario(new ScenarioModel("failing")
            .withStatus(ScenarioStatus.FAILED));
        story.addScenario(new ScenarioModel("pending")
            .withStatus(ScenarioStatus.PENDING));

        When("statistics are counted");
        RunStatistics stats = story.runStatistics();

        Then("there is one scenario for each status");
        assertEquals(1, stats.passed());
        assertEquals(1, stats.failed());
        assertEquals(1, stats.pending());
    }

}
