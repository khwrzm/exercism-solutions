(ns cars-assemble)

(def success-list '(0 100 100 100 100 90 90 90 90 80 77))

(defn cars-count
  [speed]
  (* 221 speed))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (double (* (cars-count speed) (/ (nth success-list speed) 100))))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (Math/floor (/ (production-rate speed) 60))))
