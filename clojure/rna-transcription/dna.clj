(ns dna)

(def m
  "Look-up from DNA to RNA nucleotide."
  {\G \C, \C \G, \T \A, \A \U})

(defn- ex-msg
  [dna]
  (str "Invalid DNA strand. Only the nucleotides " (apply str (keys m)) " are valid. Found: " dna))

(defn to-rna
  "Convert a DNA strand to an RNA strand."
  [dna]
  (let [rna (apply str (map m dna))]
    (if (= (count dna) (count rna))
      rna
      (throw (AssertionError. (ex-msg dna))))))
