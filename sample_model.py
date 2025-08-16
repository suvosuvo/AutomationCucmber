"""Simple model sampler for demonstration purposes.

This module contains a small function that returns factual answers for
predefined prompts. If the prompt is unknown, a ValueError is raised to
simulate hallucination detection.
"""
from typing import Dict


def sample_model(prompt: str) -> str:
    """Return a factual answer for known prompts.

    Parameters
    ----------
    prompt: str
        The question or prompt to the model.

    Returns
    -------
    str
        The model's answer.

    Raises
    ------
    ValueError
        If the prompt is unknown, indicating a hallucination.
    """
    knowledge: Dict[str, str] = {
        "What is the capital of France?": "Paris",
        "What is 2 + 2?": "4",
    }
    if prompt in knowledge:
        return knowledge[prompt]
    raise ValueError("Model hallucinated: unknown prompt")
