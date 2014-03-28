(ns robot)

(def robot-names [])

(defn str-from-fn
  [n f]
  (apply str (take n (repeatedly f))))

(defn rand-char
  [n]
  (str-from-fn n #(char (+ (int \A) (rand 26)))))

(defn rand-num
  [n]
  (str-from-fn n #(int (rand 10))))

(defn generate-name
  []
  (str (rand-char 2) (rand-num 4)))

(defn robot
  []
  (atom {:name (generate-name)}))

(defn robot-name
  [bot]
  (:name @bot))

(defn reset-name
  [bot]
  (swap! bot #(assoc % :name (generate-name))))
