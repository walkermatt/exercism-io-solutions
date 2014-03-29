(ns robot)

(defn rand-char
  []
  (char (first (shuffle (range (int \A) (inc (int \Z)))))))

(defn rand-num
  []
  (int (rand 10)))

(defn generate-name
  []
  (str (rand-char) (rand-char) (rand-num) (rand-num) (rand-num) (rand-num)))

(defn robot
  []
  (atom {:name (generate-name)}))

(defn robot-name
  [bot]
  (:name @bot))

(defn reset-name
  [bot]
  (let [n (generate-name)]
    (swap! bot assoc :name n)))