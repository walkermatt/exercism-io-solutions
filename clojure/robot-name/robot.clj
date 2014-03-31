(ns robot)

(def names (ref #{}))

(defn rand-char
  []
  (char (rand-nth (range (int \A) (inc (int \Z))))))

(defn rand-num
  []
  (rand-int 10))

(defn generate-name
  []
  (str (rand-char) (rand-char) (rand-num) (rand-num) (rand-num) (rand-num)))

(defn unique-name
  ([] (unique-name 1000))
  ([max-tries]
   (dosync
     (let [n (first (drop-while #(@names %) (repeatedly max-tries generate-name)))]
       (if (nil? n)
         (throw (Exception. "Failed to generate a unique name"))
         (do (ref-set names (conj @names n)) n))))))

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
