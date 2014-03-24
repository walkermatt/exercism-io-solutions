(ns dna)

(def nucleotides (set [\A \C \G \T \U]))
(def dna-nucleotides (disj nucleotides \U))

(defn nucleotide-counts
  [s]
  (if (every? dna-nucleotides s)
    (merge-with + (reduce #(assoc % %2 0) {} dna-nucleotides) (frequencies s))
    (throw (AssertionError. "invalid nucleotide"))))

(defn count
  [c s]
  (if (contains? nucleotides c)
    (get (nucleotide-counts s) c 0)
    (throw (Exception. "invalid nucleotide"))))

