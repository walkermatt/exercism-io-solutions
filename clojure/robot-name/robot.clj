(ns robot)

(def names (atom {:last nil :all #{}}))

(defn rand-char
  []
  (char (rand-nth (range (int \A) (inc (int \Z))))))

(defn rand-num
  []
  (rand-int 10))

(defn generate-name
  []
  (str (rand-char) (rand-char) (rand-num) (rand-num) (rand-num) (rand-num)))

(defn add-unique-name
  "When passed a `map` of `{:last <most recently added name> :all <set of all
  previously generated names>}` attempts to generate a name that is not present
  in the `:all` `set` and returns the map with new name added to `:all` and
  assigned to `:last`."
  ([names] (add-unique-name names 1000))
  ([names max-tries]
    (if-let [n (first (drop-while (:all names) (repeatedly max-tries generate-name)))]
        (-> names
            (assoc :last n)
            (update-in [:all] conj n))
      (throw (Exception. "Failed to generate a unique name")))))

(defn unique-name
  []
  (:last (swap! names add-unique-name)))

(defn robot
  []
  (atom {:name (unique-name)}))

(defn robot-name
  [bot]
  (:name @bot))

(defn reset-name
  [bot]
  (let [n (unique-name)]
    (swap! bot assoc :name n)))
