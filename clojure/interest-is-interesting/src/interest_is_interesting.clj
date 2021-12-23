(ns interest-is-interesting)

(defn interest-rate
  "TODO: add docstring"
  [balance]
  (cond
    (< balance 0) -3.213
    (< balance 1000) 0.5
    (< balance 5000) 1.621
    :else 2.475))

(defn interest-rate-conv
  "TODO: add docstring"
  [balance rate]
  (* balance (bigdec rate) 0.01M))

(defn- abs [n] (max n (* n -1)))
(defn annual-balance-update
  "TODO: add docstring"
  [balance]
  (+ balance (interest-rate-conv (abs balance) (interest-rate balance))))

(defn amount-to-donate
  "TODO: add docstring"
  [balance tax-free-percentage]
  (if (pos? balance)
    (int (* 2 (interest-rate-conv balance tax-free-percentage)))
    0))
