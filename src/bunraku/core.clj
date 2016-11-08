(ns bunraku.core
  (:import [org.openqa.selenium.chrome ChromeDriver]
           [org.openqa.selenium By]))

(defn chrome-driver
  []
  {:driver (new ChromeDriver)
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

(defn click
  [{:keys [driver element] :as original}]
  (.click element)
  original)

(defn test-script
  []
  (-> (chrome-driver)
    (get-url "https://youtube.com")
    (find-element-by-css "#masthead-search-term")
    (send-text "vaporwave")
    submit-form
    (find-element-by-css "#results .item-section li:nth-child(2) .yt-uix-sessionlink")
    click
    page-title))
