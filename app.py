from flask import Flask, jsonify

app = Flask(__name__)


@app.get('/health')
def health() -> tuple:
    """Return simple health status."""
    return jsonify(status='ok')


if __name__ == '__main__':
    app.run()
