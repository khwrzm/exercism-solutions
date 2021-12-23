(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (birds (dec (count birds))))

(defn inc-bird [birds]
  (assoc birds (dec (count birds)) (inc (today birds))))

(defn day-without-birds? [birds]
  (reduce (fn [accums cur] (or accums (= cur 0))) false birds))

(defn n-days-count [birds n]
  (reduce + 0 (subvec birds 0 n)))

(defn busy-days [birds]
  (reduce (fn [accums cur] (if (> cur 4) (inc accums) accums)) 0 birds))

(defn odd-week? [birds]
  (first (reduce (fn [[bol prev] cur] [(and bol (= prev (- 1 cur))) cur])
          [true (- 1 (first birds))]
          birds)))
