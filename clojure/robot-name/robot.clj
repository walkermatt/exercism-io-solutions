(ns robot)

(defn rand-char
  []
  (char (rand-nth (range (int \A) (inc (int \Z))))))

(defn rand-num
  []
  (rand-int 10))

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
