
document.addEventListener("DOMContentLoaded", function () {

    // Typing animation
    const heading = document.getElementById("typing");

    const words = [
        "Computer Enthusiast",
        "Python Learner",
        "Future Developer",
        "Technology Lover"
    ];

    let wordIndex = 0;
    let charIndex = 0;
    let deleting = false;

    function typeEffect() {

        let currentWord = words[wordIndex];

        if (deleting) {
            charIndex--;
        } else {
            charIndex++;
        }

        heading.textContent =
            currentWord.substring(0, charIndex);

        let speed = deleting ? 50 : 100;

        if (!deleting && charIndex === currentWord.length) {
            deleting = true;
            speed = 1200;
        }

        if (deleting && charIndex === 0) {
            deleting = false;
            wordIndex = (wordIndex + 1) % words.length;
            speed = 400;
        }

        setTimeout(typeEffect, speed);
    }

    typeEffect();

    // Scroll reveal animation
    const sections = document.querySelectorAll(".section");

    sections.forEach(function(section) {
        section.classList.add("reveal");
    });

    const observer = new IntersectionObserver(function(entries) {

        entries.forEach(function(entry) {

            if (entry.isIntersecting) {
                entry.target.classList.add("show");
            }

        });

    }, {
        threshold: 0.15
    });

    sections.forEach(function(section) {
        observer.observe(section);
    });

    // Welcome console message
    console.log("Welcome to Abbas's Portfolio!");
    console.log("Website loaded successfully!");

});
