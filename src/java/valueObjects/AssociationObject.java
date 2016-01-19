package java.valueObjects;

import java.util.Set;

public class AssociationObject implements Comparable<AssociationObject>{
        private Set<String> lhs;
        private Set<String> rhs;
        private Double confidence;
        private Double support;
        
        public AssociationObject(Set<String> lhs, Set<String> rhs,
                        Double confidence, Double support) {
                this.setLhs(lhs);
                this.setRhs(rhs);
                this.confidence = confidence;
                this.setSupport(support);
        }

        @Override
        public int compareTo(AssociationObject o) {
                if (this.confidence < o.confidence)
                        return 1;
                return 0;
        }

        public void setRhs(Set<String> rhs) {
                this.rhs = rhs;
        }

        public Set<String> getRhs() {
                return rhs;
        }

        public void setLhs(Set<String> lhs) {
                this.lhs = lhs;
        }

        public Set<String> getLhs() {
                return lhs;
        }

        public void setSupport(Double support) {
                this.support = support;
        }

        public Double getSupport() {
                return support;
        }
        
        public Double getConfidence() {
                return confidence;
        }
        

}

