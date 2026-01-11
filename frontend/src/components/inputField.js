import { LitElement, html, css } from "lit";

export class InputField extends LitElement {
    static properties = {
        label:  { type: String },
        type: { type: String },
        placeholder: { type: String }
    };

    static styles = css`
        .input-group {
            margin-bottom: 20px;
        }

        .input-label {
            display: block;
            font-size: 0.875rem;
            font-weight: 500;
            color: #B5B5B5;
            margin-bottom:  8px;
            user-select: none;
            transition: color 0.2s ease;
        }

        .input-field {
            width: 100%;
            padding: 12px 16px;
            box-sizing: border-box;
            background-color: #202020;
            color: #EDEDED;
            border: 2px solid #444444;
            border-radius: 10px;
            font-size:  0.95rem;
            transition: all 0.3s ease;
            outline: none;
        }

        .input-field:hover {
            border-color: #5a5a5a;
            background-color: #252525;
        }

        . input-field:focus {
            border-color: #4F9DFF;
            background-color: #2a2a2a;
            box-shadow: 0 0 0 3px rgba(79, 157, 255, 0.1);
        }

        .input-field:focus + .input-label,
        .input-group:focus-within .input-label {
            color: #4F9DFF;
        }

        .input-field:: placeholder {
            color: #666;
        }
    `;

    getValue() {
        const input = this.renderRoot.querySelector('.input-field');
        return input ? input.value : '';
    }

    render() {
        return html`
            <div class="input-group">
                <label class="input-label">${this.label}</label>
                <input class="input-field" type="${this. type}" placeholder="${this.placeholder}" />
            </div>
        `;
    }
}

customElements.define("input-field", InputField);