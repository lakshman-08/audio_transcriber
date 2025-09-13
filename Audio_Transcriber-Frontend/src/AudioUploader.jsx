import { useState } from "react";
import axios from "axios";

const AudioUploader = () => {
  const [file, setFile] = useState(null);
  const [transcription, setTranscription] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  // Handle file selection
  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
    setTranscription(""); // clear old result
    setErrorMessage("");  // clear old error
  };

  const handleUpload = async () => {
    if (!file) {
      setErrorMessage("Please select a file first.");
      return;
    }

    const formData = new FormData();
    formData.append("file", file);

    try {
      const response = await axios.post(
        "http://localhost:8080/api/transcriber", // ✅ must match backend
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        }
      );

      setTranscription(response.data); // ✅ backend transcription text
      setErrorMessage(""); // clear error if success
    } catch (error) {
      if (error.response) {
        // ✅ show backend error (e.g., 429 too many requests)
        setErrorMessage(error.response.data);
      } else if (error.request) {
        setErrorMessage("No response from server. Please try again.");
      } else {
        setErrorMessage("Unexpected error occurred.");
      }
      setTranscription(""); // clear old result if error
    }
  };

  return (
    <>
      <h1>Audio To Text Transcriber</h1>

      <div className="file-input">
        <input type="file" accept="audio/*" onChange={handleFileChange} />
      </div>

      <button className="upload-button" onClick={handleUpload}>
        Upload and Transcribe
      </button>

      {/* Show error */}
      {errorMessage && (
        <div style={{ color: "red", marginTop: "10px" }}>{errorMessage}</div>
      )}

      {/* Show transcription */}
      {transcription && (
        <div className="transcription-result" style={{ marginTop: "10px" }}>
          <h2>Transcription Result:</h2>
          <p style={{ color: "green" }}>{transcription}</p>
        </div>
      )}
    </>
  );
};

export default AudioUploader;

