(ns dna)

(def m
  "Look from DNA to RNA nucleotide."
  {\G \C, \C \G, \T \A, \A \U})

(defn- ex-msg
  [s]
  (str "Invalid DNA strand. Only the nucleotides " (apply str (keys m)) " are valid. Found: " s))

(defprotocol ToRna
  "Returns the RNA complement of a given DNA nucleotide or strand"
  (to-rna [dna]))

(extend-protocol ToRna
  java.lang.Character
  (to-rna [dna]
    (or (get m dna) (throw (AssertionError. (ex-msg dna)))))
  java.lang.String
  (to-rna [dna]
    (apply str (map #(to-rna %) dna))))

