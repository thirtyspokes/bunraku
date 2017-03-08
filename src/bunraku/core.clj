(ns bunraku.core
  (:import [org.openqa.selenium.chrome ChromeDriver]
           [org.openqa.selenium.htmlunit HtmlUnitDriver]
           [org.openqa.selenium By]))

(defn chrome-driver
  []
  {:driver (new ChromeDriver)
   :element nil})

(defn html-driver
  []
  {:driver (new HtmlUnitDriver)
   :element nil})

(defn get-url
  [{:keys [driver element] :as original} url]
  (.get driver url)
  original)

(defn find-element-by-css
  [{:keys [driver element]} selector]
  (let [element (.findElement driver (By/cssSelector selector))]
    {:driver driver :element element}))

(defn send-text
  [{:keys [driver element] :as original} text]
  (.sendKeys element (into-array [text]))
  original)

(defn submit-form
  [{:keys [driver element] :as original}]
  (.submit element)
  original)

(defn page-title
  [{:keys [driver element]}]
  (Thread/sleep 1500)
  (.getTitle driver))

(defn get-current-url
  [{:keys [driver element]}]
  (.getCurrentUrl driver))

(defn click
  [{:keys [driver element] :as original}]
  (.click element)
  original)
