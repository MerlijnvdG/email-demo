import { LitElement, html, css } from 'lit';
import "./inputField.js";
import { MailService } from "./mailService.js";

export class SenderContainer extends LitElement {
    static styles = css`
        .container {
            border: 1px solid #464646;
            padding: 32px;
            border-radius: 16px;
            background: linear-gradient(135deg, #343434 0%, #2a2a2a 100%);
            max-width: 800px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.4);
            position: relative;
            overflow: hidden;
        }

        .container::before {
            content: '';
            position:  absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 4px;
            background: linear-gradient(90deg, #FF6B9D, #FFA06B, #FFD56B);
            border-radius: 16px 16px 0 0;
        }

        h2 {
            color: #EAEAEA;
            margin-top: 0;
            margin-bottom: 24px;
            font-size: 1.5rem;
            font-weight: 700;
            display: flex;
            align-items: center;
            gap: 12px;
        }

        .send-button {
            background: linear-gradient(135deg, #4F9DFF 0%, #3d7dd9 100%);
            color: white;
            padding: 14px 28px;
            border: none;
            border-radius: 10px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            margin-top: 16px;
            width: 100%;
            transition: all 0.3s ease;
            box-shadow: 0 4px 12px rgba(79, 157, 255, 0.3);
            position: relative;
            overflow: hidden;
        }

        .send-button::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(255,255,255,0.2), transparent);
            transition: left 0.5s ease;
        }

        .send-button:hover::before {
            left:  100%;
        }

        .send-button:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(79, 157, 255, 0.4);
        }
    `;
    getFieldValue(label) {
        const input = this.renderRoot.querySelector(`input-field[label="${label}"]`)
        return input ? input.getValue() : '';
    }
    sendMail() {
        const email = (this.getFieldValue("Naar"))
        const subject = (this.getFieldValue("Onderwerp"))
        const message = (this.getFieldValue("Bericht"))

        MailService.sendMail(email, subject, message)
          .then(() => {
              alert("E-mail succesvol verzonden!");
          })
          .catch((error) => {
              alert("Fout bij het verzenden van de e-mail: " + error.message);
          });
    }

    render() {
        return html`
        <div class="container">
            <h2>Simpele email met tekst content</h2>
            <input-field label="Naar" type="email" placeholder="example@mail.com"></input-field>
            <input-field label="Onderwerp" type="text" placeholder=""></input-field>
            <input-field label="Bericht" type="text" placeholder=""></input-field>
    
            <button class="send-button" @click=${this.sendMail}>Verzenden</button>
        </div>
        `
    }


}
customElements.define('sender-container', SenderContainer);