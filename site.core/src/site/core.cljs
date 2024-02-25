(ns ^:figwheel-hooks site.core
  (:require [clojure.string :refer [split]]
            [goog.dom :as gdom]
            [reagent.core :as reagent :refer [atom]]
            [reagent.dom :as rdom]))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn get-app-element []
  (gdom/getElement "app"))

; Styles
(def header "text-left text-xl md:text-3xl box-decoration-clone text-[#ffaa00] px-2 mt-10")
(def header-big "shrink text-left text-2xl md:text-4xl text-[#ffaa00] px-2 mb-4 mt-14")
(def project "p-6 border-4 border-amber-100 transition mt-6 rounded mb-6 shadow-sm shadow-neutral-900")
(def nav-button "hover:bg-lime-800 flex text-amber-100 p-3 text-center")
(def img "my-3 shadow-lg rounded-sm place-content-center")
(def photo "my-4 mb-8 shadow-lg rounded-sm w-11/12 border-8 border-amber-100")
(def social "fa hover:scale-125 transition p-4")
(def global "font-roboto text-sm md:text-base scroll-auto bg-lime-800 text-amber-100")
(def audio-text "text-amber-100 mb-1 text-xs md:text-sm")
(def tag "text-center text-xl md:text-3xl mb-4 mt-12")


; Navbar
(defn navbar []
  [:nav {:class "flex justify-between bg-lime-900 text-amber-100 block fixed top-0 left-0 right-0"}
   [:div {:href "" :class "flex"}
    [:a {:href "#top" :class nav-button} "Christian Stjernberg"]
    [:a {:href "#projects" :class nav-button} "Projects"]
    [:a {:href "#photography" :class nav-button} "Photography"]]
   [:div {:class "hidden sm:flex"}
    [:a {:href "https://www.instagram.com/christians_fotografi/" :target "_blank" :class ["fa-instagram" social]}]
    [:a {:href "https://github.com/christian-stj/" :target "_blank" :class ["fa-github" social]}]
    [:a {:href "https://www.linkedin.com/in/christian-stj/" :target "_blank" :class ["fa-linkedin" social]}]]])



(defn tagline []
  [:div {:class tag}
   [:em "People, software, music"]])

(defn intro []
  [:div {:class "mb-10"}
   [:h1 {:class header-big} "About me"]
   [:img {:class "float-right transition duration-700 w-1/2 md:w-1/3 xl:w-1/4 rounded-full border-4 border-amber-100 m-4" :src "./img/portrait-christian.jpg"}]
   [:div {:class "px-2 my-3"}
    [:p  "Hej! 👋" [:br]
     "Welcome to my personal page!
      My name is Christian and you may find me developing software, talking about leadership, teams, and culture and a myriad of other things.
      My interests include music, photography and technology.
      I'm also very active with multiple different non-profit organizations, mainly working with youth.
      This is where I keep some of my technical projects and photography, check them out!"]]])

(def instagram-img-sources (split "./instagram/399885630_377510514700373_8403928561865487818_n.webp ./instagram/173022412_268339418272047_1093431580254147613_n.jpg ./instagram/173080697_506111990420742_6259152929652378186_n.jpg ./instagram/174867484_122504219821507_3048476703950039340_n.jpg ./instagram/175348710_228415745737349_5537444018371090008_n.jpg ./instagram/176209918_184619130158038_786649798004349307_n.jpg ./instagram/177039207_968001270683151_6447398338399227417_n.jpg ./instagram/235767804_151515103791234_1673290746420710077_n.jpg ./instagram/236903349_870350607199238_8841531014078710008_n.jpg ./instagram/242765492_391114712691098_2640414364288285619_n.jpg ./instagram/271834001_461171578952340_1762667053030519977_n.webp ./instagram/312096996_424836823160563_6160720423345877099_n.webp ./instagram/332354676_1042493510044804_8887406124638804060_n.webp ./instagram/357550178_807940630717679_7539186842275922397_n.jpg" " "))

(defn photography []
  [:div {:id "photography"}
   [:h2 {:class header-big} "Photography"]
   [:ul (map (fn [src] [:li {:class "flex justify-center"} [:img {:class photo :src src}]]) instagram-img-sources)]])

(defn projects []
  [:div {:id "projects"}
   [:h2 {:class header-big} "My projects"]
   [:div
       ;; This is where projects go
    [:div {:class project}
     [:span {:class header} "/"]
     [:iframe {:class "aspect-square w-full my-3 shadow-lg" :src "https://christian.stjernberg.com" :title "Christian Stjernberg"}]
     [:p "What is this? Pageception? This is my most recent project, I rewrote and updated my old site with clojurescript.
          I used Reagent and Tailwind for layout and styling and Leiningen and Figwheel as build/dev tools.
          The site got a complete new style and it is now also easier to expand and add to the site."]]
    [:div {:class project}
     [:span {:class header} "Alert sound"]
     [:div {:class "my-3 space-y-3"}
      [:div
       [:p {:class audio-text} "\"Slideoff\""]
       [:audio {:controls "true"}
        [:source {:src "./audio/CS_sound1_slideoff.mp3"}]]]
      [:div
       [:p {:class audio-text} "\"Slideoff\" - in context"]
       [:audio {:controls "true"}
        [:source {:src "./audio/CS_sound1_with_background.mp3"}]]]
      [:div
       [:p {:class audio-text} "\"Fifth\""]
       [:audio {:controls "true"}
        [:source {:src "./audio/CS_sound2_fifth.mp3"}]]]
      [:div
       [:p {:class audio-text} "\"Fifth\" - in context"]
       [:audio {:controls "true"}
        [:source {:src "./audio/CS_sound2_with_background.mp3"}]]]]
     [:p "For a musical communication course, we were tasked with designing an alert sound for a retail store environment.
              The sound was supposed to blend in well with the background audio (which was given to us) but also to be noticeable by staff.
              This kind of sound could be used to alert staff without being too intrusive.
              For example, the sound could be played when someone reached onto a shelf of valuable items.
              I designed the sounds by recording my guitar and using audio effects to make it blend well."]]
    [:div {:class project}
     [:span {:class header} "cljs-snake"]
     [:a {:href "http://christian.stjernberg.com/cljs-snake/" :target "_blank"}
      [:img {:class img :src "./img/snake.png"}]]
     [:p "A simple snake game project I made to test out reagent and web programming with clojurescript.
              The snake is controlled using arrow keys and the playing grid wraps around the top and sides."]]
    [:div {:class project}
     [:span {:class header} "Bee Game"]
     [:a {:href "https://github.com/christian-stj/bee-game" :target "_blank"}
      [:img {:class img :src "./img/bee_game_screens.png"}]]
     [:p "This game was made in one evening after a little bee had visited our ice-cream during lunch.
          The bee had some ice-cream stuck on it and chilled out on my hand for a few minutes while cleaning it out.
          In the game the bee must escape the falling stracciatella ice-cream for as long as possible.
          When struck, the bee is covered with ice-cream and the final score is shown on top.
          I developed the game using Python and the Pygame library. I also created the fantastic artwork myself."]]
    [:div {:class project}
     [:span {:class header} "GitViz - a GitHub Visualization tool"]
     [:a {:href "https://github.com/christian-stj/Visualizing-GitHub" :target "_blank"}
      [:img {:class img :src "./img/gitviz1.png" :alt "GitHub Visualization - Small repo"}]]
     [:p "For my bachelor thesis, I developed a visualization tool that visualizes GitHub data together with my thesis partner.
          The graph in the middle shows all repo files and directories as nodes with color and size varying depending on the
          distance from the root. The visualization can be dragged and scrolled and the nodes can also be dragged around.
          To the left there are two menus, one where you can go to different commits and see the file tree at that point in time and
          one where you can see different issues."]
     [:a {:href "https://github.com/christian-stj/Visualizing-GitHub" :target "_blank"}
      [:img {:class img :src "./img/gitviz2.png" :alt "GitHub Visualization - BIG repo"}]]
     [:p "On encouragement from our supervisor we added dark mode because these are a must in modern websites.
          As you can see on the image above the tool did not handle huge repositories well."]]
    [:div {:class project}
     [:span {:class header} "Todo List App"]
     [:img {:class img :src "./img/todo-list.png"}]
     [:p "This was a full-stack project for a web programming course. I developed the app together with "
      [:a {:class "text-gray-400" :href "https://github.com/mansand1" :target "_blank"} "@mansand1"]
      " The application was developed with Vue front-end using node backend featuring a nice ORM SQLite database.
          Users could log in and their passwords were salted and hashed and stored in the database together
          with their list information. The site also had a self-signed TLS certificate and was hosted on the
          local machine. "]]
    [:div {:class project}
     [:span {:class header} "Tiny Guitar Hero"]
     [:img {:class img :src "./img/guitar-hero-game.jpg"}]
     [:p "For a project in embedded programming, me and "
      [:a {:class "text-gray-400" :href "https://github.com/theoahfeldt" :target "_blank"} "@theoahfeldt"]
      " developed a Guitar Hero replica. The program was developed for a PIC32 microcontroller using an IO shield and some external buttons
          connected to hardware pins on the chip.
          As you can see on the tiny screen in the image above the player is presented with some dots running
          down the screen where the player must
          press the right combination of buttons and the strum button att the right time to score.
          On the screen above, the player seems to have been a bit early in strumming as is displayed on the screen."]
     [:img {:class img :src "./img/guitar.jpg"}]
     [:p "The entire thing was packed in a flaming hot red case and gathered much interest at the project conference where
          students got to try out each other's projects. The tiny screen was placed inside the little rectangular slot at the side
          of the guitar neck and then a speaker was connected to the microcontroller playing som terribly off-beat square waves.
          Of course, no one could beat my high-score in the game."]]
    [:div {:class project}
     [:span {:class header} "Crappy Chess"]
     [:a {:href "https://github.com/christian-stj/crappy-chess" :target "_blank"}
      [:img {:class img :src "./img/chess.png"}]]
     [:p "For our first \"major\" (3 weeks) project in school at the end of first year (back in 2018). A chess game developed with GoLang using game library Ebiten.
          The players took turns to move
          their pieces to any legal square and the game ended with the capture of the opposing king. The rules castling, en passant and
          pawn promotion as well as check and checkmate were not implemented in the game, hence the \"crappyness\"."]]]])

(defn footer []
  [:footer {:class "w-full text-xl block text-center"}
   [:p {:class "bg-lime-900 box-decoration-clone tracking-wide p-4"} "© Christian Stjernberg - 2024"]])

; Main app
(defn app []
  [:div {:class global}
   ;; Top
   [navbar]
   ;; Body
   [:div {:class "flex flex-row justify-center m-3"}
    ;; Main Content
    [:div {:class "md:basis-2/4 center max-w-xs md:max-w-none pt-6"}
     [tagline]
     [intro]
     [projects]
     [photography]]]
   [footer]])


(defn mount [el]
  (rdom/render [app] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^:after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element))
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
