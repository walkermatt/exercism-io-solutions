(ns dna)

(def m
  "Look from DNA to RNA nucleotide."
  {\G \C, \C \G, \T \A, \A \U})

(defn to-rna
  "Convert a DNS strand to an RNA strand."
  [dna]
  (let [rna (apply str (map #(get m %) dna))]
    (if (= (count dna) (count rna))
      rna
      (throw (AssertionError. (str "Invalid DNA strand. Only the nucleotides " (apply str (keys m)) " are valid."))))))
