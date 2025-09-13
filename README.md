<h1 align="center">🎤 Audio to Text Transcriber using OpenAI</h1>

<p align="center">
  A mini full-stack application that converts audio files into text using the <b>OpenAI Audio Models</b>.  
  Built with <b>ReactJS</b> for the frontend, <b>Spring Boot</b> for the backend, and <b>OpenAI APIs</b> for audio transcription.  
</p>

---

## 📖 Project Description  

This project demonstrates how to build a full-stack application that leverages **AI-based transcription services**.  
Users can upload an audio file (speech, recorded conversation, or generated sample audio), and the backend will process the file using **OpenAI’s Audio Transcription API**.  
The result is a clean text transcription that can be displayed on the frontend.  

It is a practical example of combining **AI services** with modern **full-stack development** to solve real-world use cases like:  
- Meeting transcription  
- Voice note conversion  
- Accessibility for people with hearing disabilities  

---

## 🌟 Features  

- 🎧 **Upload Audio Files** directly from the frontend (ReactJS).  
- ⚙️ **Backend Processing** with Spring Boot and integration with **OpenAI API**.  
- 🧠 **AI-powered Transcription** using `AudioTranscriptionPrompt` class.  
- 📜 **Display Text Results** instantly on the frontend.  
- ⚡ **Responsive Frontend UI** styled with CSS.  
- 🔑 **API Key-based Authentication** for secure communication with OpenAI.  
- 💰 **Cost Awareness**: Warns users about the requirement of having **$5–$10 OpenAI credits** to avoid 500 errors.  
- 🤖 **GitHub Copilot Assistance** was used for faster frontend development.  

---

## 🚀 Technologies Used  

<p align="center">
  <!-- React -->
  <img src="https://media.giphy.com/media/eNAsjO55tPbgaor7ma/giphy.gif" width="60" height="60" alt="ReactJS" />
  
  <!-- Spring Boot -->
  <img src="https://upload.wikimedia.org/wikipedia/commons/4/44/Spring_Framework_Logo_2018.svg" width="120" height="120" alt="Spring Boot" />

  
  <!-- OpenAI -->
  <img src="https://media.giphy.com/media/CuMiNUVZ8yJszd2h3s/giphy.gif" width="60" height="60" alt="OpenAI" />
  
  <!-- CSS3 -->
  <img src="https://media.giphy.com/media/IdyAQJVN2kVPNUrojM/giphy.gif" width="60" height="60" alt="CSS3" />
</p>



---

## ⚙️ Internal Working  

1. User uploads an **audio file** from the frontend (ReactJS).  
2. The **Spring Boot backend controller** receives the request.  
3. Inside the controller method, the **`AudioTranscriptionPrompt`** class is used to process the audio.  
4. OpenAI API generates the **transcribed text** as a response.  
5. The response is sent back to the frontend and displayed to the user.  

---

## 🔑 Setup OpenAI API Key  

- You must have an **OpenAI API key** with at least **$5–$10 credits** to use audio APIs.  
- Without enough credits, you may face **500 Internal Server Error**.  

👉 [Generate your API Key here](https://platform.openai.com/settings/organization/api-keys)  

---

## 📖 Reference Documentation  

To configure and initialize the OpenAI API in Spring Boot, refer to:  
👉 [Spring AI OpenAI Transcriptions Docs](https://docs.spring.io/spring-ai/reference/api/audio/transcriptions/openai-transcriptions.html)  

---

## 🎧 Generate Sample Audio Files  

To test your project, you can generate sample audio files by converting text to speech:  
👉 [TTS MP3 Converter](https://ttsmp3.com/)  

---

## 🤖 AI Assistance  

The **frontend part** of this project was accelerated using **GitHub Copilot** to save development time.  

---


<h3 align="center">✨ Developed with ❤️ using ReactJS, Spring Boot & OpenAI ✨</h3>
